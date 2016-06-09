package ServerNetwork.BungeeCore.Main.BungeeCore.game;

import net.md_5.bungee.api.ChatColor;

/**
 * Created by Jake(BadEntites)
 */
public enum Rank {

    ADMIN("Admin", ChatColor.RED + "[Admin]", 10),
    Developer("Developer", ChatColor.RED + "[Developer]", 10),
    MOD("Mod", ChatColor.DARK_GREEN + "[MOD]", 5),
    HELPER("Helper", ChatColor.BLUE + "[HELPER]", 3),
    DEFAULT("Default", ChatColor.GRAY + "", 0)
    ;

    public String name;
    public String tab;
    public int weight;

    Rank(String name, String tab, int weight) {
        this.name = name;
        this.tab = tab;
        this.weight = weight;
    }

    public String getName() {

        return this.name;
    }

    public String getTab() {

        return this.tab;
    }

    public int getWeight() {

        return this.weight;
    }


}
