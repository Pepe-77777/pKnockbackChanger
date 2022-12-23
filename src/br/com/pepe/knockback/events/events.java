package br.com.pepe.knockback.events;

import br.com.pepe.knockback.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class events implements Listener {

    @EventHandler
    public void onDamageEvent(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            int vertical = Main.getMain().getConfig().getInt("knockback-vertical");
            int horizontal = Main.getMain().getConfig().getInt("knockback-horizontal");

            Entity p = e.getEntity();

            p.setVelocity(p.getLocation().getDirection().setY(0).normalize().multiply(vertical));
            p.setVelocity(p.getLocation().getDirection().setX(0).normalize().multiply(horizontal));

        }

    }


}
