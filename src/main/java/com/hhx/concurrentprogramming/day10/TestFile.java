package com.hhx.concurrentprogramming.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author he
 * @date 2021/11/19
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day10
 */

public class TestFile {
    public static void main(String[] args) {
        String s="{\"MPItemFeedHeader\":{\"subset\":\"EXTERNAL\",\"subCategory\":\"animal_accessories\",\"locale\":\"en\",\"sellingChannel\":\"marketplace\",\"version\":\"1.3\",\"processMode\":\"REPLACE\"},\"MPItem\":[{\"Visible\":{\"Animal Accessories\":{\"shortDescription\":\"<li>Note: If you have any mentioned insect or hamster as pet, please do not use this product.</li><li>No Noise: The sound emits from LIGHTSMAX ultrasonic repeller is only audible to pests and rodents.</li>\",\"mainImageUrl\":\"http://i5.walmartimages.com/asr/5a10f160-be0d-4400-b191-772415c83f42_1.f8776a378a0974b65f5eee6354ff805d.jpeg?odnHeight=180&odnWidth=180&odnBg=ffffff\",\"productSecondaryImageURL\":[\"http://i5.walmartimages.com/asr/5a10f160-be0d-4400-b191-772415c83f42_1.f8776a378a0974b65f5eee6354ff805d.jpeg?odnHeight=180&odnWidth=180&odnBg=ffffff\"]}},\"Orderable\":{\"productName\":\"6 PK [2018 NEW UPGRADED] LIGHTSMAX - Ultrasonic Pest Repeller - Electronic Plug -In Pest Control Ultrasonic - Best Repellent for Cockroach Rodents Flies Roaches Ants Mice Spiders Fleas Indoor\",\"productIdentifiers\":{\"productId\":\"00705595977903\",\"productIdType\":\"gtin\"},\"price\":\"17.92\",\"sku\":\"1111\",\"ShippingWeight\":\"1111\",\"brand\":\"Lightsmax\"}}]}";

        File file = new File("1.json");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(s.getBytes());
            fileOutputStream.close();
            if (file.exists()){
                file.delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
