package com.angelolagreca.agreeworld.entities.chain;

import com.angelolagreca.agreeworld.common.HashUtil;
import com.angelolagreca.agreeworld.entities.agreeworld.Card;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Block {

    private final static Logger LOGGER = LoggerFactory.getLogger(Block.class);

    private String hash;
    private final String previousHash;
    private final Card card;
    private final long timeStamp;
    private int nonce;

    public Block(Card data, String previousHash) {
        this.previousHash = previousHash;
        this.card = data;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();

    }

    public String calculateHash() {
        return HashUtil.applySha256(previousHash + timeStamp + card + nonce);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        LOGGER.info("Block Mined!!! : " + hash);
    }


    public static final class BlockBuilder {
        private String hash;
        private String previousHash;
        private Card card;
        private long timeStamp;

        private BlockBuilder() {
        }

        public static BlockBuilder builder() {
            return new BlockBuilder();
        }

        public BlockBuilder previousHash(String previousHash) {
            this.previousHash = previousHash;
            return this;
        }

        public BlockBuilder card(Card card) {
            this.card = card;
            return this;
        }

        public Block build() {
            return  new Block(card, previousHash);

        }
    }
}
