package com.angelolagreca.agreeworld.entities.chain;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chain {

    private final static Logger LOGGER = LoggerFactory.getLogger(Chain.class);

    public static List<Block> chain = new ArrayList<>();
    public static int difficulty = 5;


    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        String hashTarget = new String(new char[difficulty]).replace('\0', '0');


        //loop through blockchain to check hashes:
        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                LOGGER.info("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                LOGGER.info("Previous Hashes not equal");
                return false;
            }
            if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
                LOGGER.info("This block hasn't been mined");
                return false;
            }
        }

        LOGGER.info("Chain is valid");
        return true;
    }

}
