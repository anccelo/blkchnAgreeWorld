package com.angelolagreca.agreeworld;

import com.angelolagreca.agreeworld.entities.Block;
import com.angelolagreca.agreeworld.entities.Chain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {


    public static final String HASH_0 = "fgjfgmùgBNef*fgaer$gjµF4A56RGµN¨TEB";

    public static void main(String[] args) {


        Chain.chain.add(Block.BlockBuilder.builder()
                .previousHash(HASH_0)
                .data("partenope").build());
        System.out.println("Trying to Mine block" + (Chain.chain.size() - 1));
        Chain.chain.get(0).mineBlock(Chain.difficulty);

        Chain.chain.add(Block.BlockBuilder.builder()
                .previousHash(Chain.chain.get(Chain.chain.size() - 1).getHash())
                .data("hamburger").build());
        System.out.println("Trying to Mine block" + (Chain.chain.size() - 1));
        Chain.chain.get(1).mineBlock(Chain.difficulty);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonChain = gson.toJson(Chain.chain);
        System.out.println(prettyJsonChain);

        Boolean result = Chain.isChainValid();


    }
}