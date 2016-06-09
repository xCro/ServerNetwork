package ServerNetwork.BungeeCore.Main.BungeeCore.database;

import ServerNetwork.BungeeCore.Main.BungeeCore.ProxyPlugin;
import ServerNetwork.BungeeCore.Main.BungeeCore.database.player.Profile;
import ServerNetwork.BungeeCore.Main.BungeeCore.game.Rank;

import java.sql.*;
import java.util.UUID;

/**
 * Created by Jake(BadEntites)
 */
public class HubDB {

    public String host;
    public String database;
    public String name;
    public String pass;
    public String player_table = "network_players";

    private Connection connection;

    // QUERIES :D //
    public String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS network_players (UUID varchar(255), Rank varchar(255))";
    public String GET_PROFILE = "SELECT * FROM network_players WHERE UUID='{uuid}'";
    public String ADD_PROFILE = "INSERT INTO network_players VALUES ({uuid}, {rank})";

    public HubDB() {
        this.host = "";
        this.database = "";
        this.name = "";
        this.pass = "";

        try {

            try {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
               e.printStackTrace();
            }

            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":3306/" + this.pass, this.name, this.pass);

            createTables();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void executeUpdateAsynchronously(final PreparedStatement preparedStatement) {
        ProxyPlugin.getInstance().getProxy().getScheduler().runAsync(ProxyPlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                try {
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void createTables() throws SQLException {
        final PreparedStatement player_table = getConnection().prepareStatement(this.CREATE_TABLE);
        executeUpdateAsynchronously(player_table);
    }

    public ResultSet get(UUID uuid) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(this.GET_PROFILE.replace("{uuid}", uuid.toString()));
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                return set;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isInside(UUID uuid) {
        return (get(uuid) != null);
    }

    public void injectPlayer(UUID uuid) {
        if(isInside(uuid)) return;
        try {
            PreparedStatement statement = getConnection().prepareStatement(this.ADD_PROFILE.replace("{uuid}", uuid.toString()).replace("{rank}", Rank.DEFAULT.getName()));
            executeUpdateAsynchronously(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profile getProfile(UUID uuid) {
        return new Profile(uuid, getRank(uuid));
    }

    public Rank getRank(UUID playerUUID) {
        try {
            return Rank.valueOf(get(playerUUID).getString("Rank").toUpperCase());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
