package com.angelolagreca.agreeworld;

import com.angelolagreca.agreeworld.entities.agreeworld.Card;
import com.angelolagreca.agreeworld.entities.chain.Block;
import com.angelolagreca.agreeworld.entities.chain.Chain;
import com.angelolagreca.agreeworld.enum_.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {


    public static final String HASH_0 = "fgjfgmùgBNef*fgaer$gjµF4A56RGµN¨TEB";

    public static void main(String[] args) {

        Chain.chain.add(Block.BlockBuilder.builder()
                .previousHash(HASH_0)
                .card(Card.CardBuilder.builder()
                        .name("Parthenope")
                        .point(70)
                        .category(Category.LEGEND)
                        .description("The siren who after trying to charm Ulysses founds the city of Naples")
                        .build())
                .build());
        System.out.println("Trying to Mine block" + (Chain.chain.size() - 1));
        Chain.chain.get(0).mineBlock(Chain.difficulty);

        Chain.chain.add(Block.BlockBuilder.builder()
                .previousHash(Chain.chain.get(Chain.chain.size() - 1).getHash())
                .card(Card.CardBuilder.builder()
                        .name("Hamburger")
                        .point(70)
                        .category(Category.FOOD)
                        .description("It consists of a bun, a proper hamburger, sauces and condiments")
                        .build())
                .build());
        System.out.println("Trying to Mine block" + (Chain.chain.size() - 1));
        Chain.chain.get(1).mineBlock(Chain.difficulty);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonChain = gson.toJson(Chain.chain);
        System.out.println(prettyJsonChain);

        Boolean result = Chain.isChainValid();
        System.out.println("The chain is valid? " + result);


    }
}