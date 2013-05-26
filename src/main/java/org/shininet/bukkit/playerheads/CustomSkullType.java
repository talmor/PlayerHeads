/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.shininet.bukkit.playerheads;

/**
* @author meiskam
*/

public enum CustomSkullType {

    SPIDER("Kelevra_V", Tools.format(Lang.HEAD_SPIDER), Lang.HEAD_SPAWN_SPIDER), // Thanks SethBling
    ENDERMAN("Violit", Tools.format(Lang.HEAD_ENDERMAN), Lang.HEAD_SPAWN_ENDERMAN), // Thanks SethBling
    BLAZE("Blaze_Head", Tools.format(Lang.HEAD_BLAZE), Lang.HEAD_SPAWN_BLAZE), // Thanks SethBling
    HORSE("gavertoso", Tools.format(Lang.HEAD_HORSE), Lang.HEAD_SPAWN_HORSE), // Thanks Glompalici0us
    SQUID("squidette8", Tools.format(Lang.HEAD_SQUID), Lang.HEAD_SPAWN_SQUID), // Thanks SethBling
    SILVERFISH("AlexVMiner", Tools.format(Lang.HEAD_SILVERFISH), Lang.HEAD_SPAWN_SILVERFISH), // Thanks SethBling
    ENDER_DRAGON("KingEndermen", Tools.format(Lang.HEAD_ENDER_DRAGON), Lang.HEAD_SPAWN_ENDER_DRAGON), // Thanks SethBling
    SLIME("HappyHappyMan", Tools.format(Lang.HEAD_SLIME), Lang.HEAD_SPAWN_SLIME), // Thanks SethBling
    IRON_GOLEM("zippie007", Tools.format(Lang.HEAD_IRON_GOLEM), Lang.HEAD_SPAWN_IRON_GOLEM), // Thanks SethBling
    MUSHROOM_COW("Mooshroom_Stew", Tools.format(Lang.HEAD_MUSHROOM_COW), Lang.HEAD_SPAWN_MUSHROOM_COW), // Thanks SethBling
    BAT("coolwhip101", Tools.format(Lang.HEAD_BAT), Lang.HEAD_SPAWN_BAT), // Thanks SethBling
    PIG_ZOMBIE("ManBearPigZombie", Tools.format(Lang.HEAD_PIG_ZOMBIE), Lang.HEAD_SPAWN_PIG_ZOMBIE), // Thanks cnaude of TrophyHeads
    SNOWMAN("Koebasti", Tools.format(Lang.HEAD_SNOWMAN), Lang.HEAD_SPAWN_SNOWMAN), // Thanks MrLeikermoser
    GHAST("_QuBra_", Tools.format(Lang.HEAD_GHAST), Lang.HEAD_SPAWN_GHAST), // Thanks MrLeikermoser
    PIG("XlexerX", Tools.format(Lang.HEAD_PIG), Lang.HEAD_SPAWN_PIG), // Thanks XlexerX
    VILLAGER("Kuvase", Tools.format(Lang.HEAD_VILLAGER), Lang.HEAD_SPAWN_VILLAGER); // Thanks XlexerX

    private final String owner;
    private final String displayName;
    private final String spawnName;

    CustomSkullType(String owner, String displayName, String spawnName) {
        this.owner = owner;
        this.displayName = displayName;
        this.spawnName = spawnName;
    }

    public String getOwner() {
        return owner;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSpawnName() {
        return spawnName;
    }
}
