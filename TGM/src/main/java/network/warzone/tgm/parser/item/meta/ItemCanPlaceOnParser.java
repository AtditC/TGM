package network.warzone.tgm.parser.item.meta;

import com.destroystokyo.paper.Namespaced;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 03/22/2020
 */
public class ItemCanPlaceOnParser implements ItemMetaParser {

    @Override
    public void parse(ItemStack itemStack, ItemMeta meta, JsonObject object) {
        if (object.has("canPlaceOn")) {
            List<Namespaced> keys = new ArrayList<>();
            for (JsonElement element : object.getAsJsonArray("canPlaceOn")) {
                if (!element.isJsonPrimitive()) {
                    continue;
                }
                keys.add(NamespacedKey.minecraft(element.getAsString()));
            }
            meta.setPlaceableKeys(keys);
        }
    }
}
