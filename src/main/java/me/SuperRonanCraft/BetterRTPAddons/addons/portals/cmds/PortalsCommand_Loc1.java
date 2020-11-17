package me.SuperRonanCraft.BetterRTPAddons.addons.portals.cmds;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import me.SuperRonanCraft.BetterRTPAddons.addons.portals.AddonPortals;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class PortalsCommand_Loc1 implements PortalsCommands, LocationFinder {

    private PacketContainer fakeBlock;

    @Override
    public void execute(CommandSender sendi, String label, String[] args, AddonPortals addonPortals) {
        Player p = (Player) sendi;
        Location loc = getTargetBlock(p, 10).getLocation();
        addonPortals.getPortals().setPortal(p, loc, false);
        sendi.sendMessage("Location 1 set to this location " + loc.toString());
        //p.sendBlockChange(loc, Material.GLOWSTONE, (byte) 0);

        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        WrapperPlayServerBlockChange fakeBlock = new WrapperPlayServerBlockChange();
        fakeBlock.setLocation(BlockLocation);
        try {
            //System.out.println(fakeBlock.toString());
            protocolManager.sendServerPacket(p, fakeBlock);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(
                    "Cannot send packet " + fakeBlock, e);
        }
    }
}
