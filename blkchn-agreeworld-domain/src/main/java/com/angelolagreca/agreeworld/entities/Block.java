package com.angelolagreca.agreeworld.entities;

import com.angelolagreca.agreeworld.common.HashUtil;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Block {

    private final static Logger LOGGER = LoggerFactory.getLogger(Block.class);

    private String hash;
    private final String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();

    }

    public String calculateHash() {
        return HashUtil.applySha256(previousHash + timeStamp + data + nonce);
    }

    public boolean mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        LOGGER.info("Block Mined!!! : " + hash);
        return true;
    }


    public static final class BlockBuilder {
        private String hash;
        private String previousHash;
        private String data;
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

        public BlockBuilder data(String data) {
            this.data = data;
            return this;
        }

        public Block build() {
            Block block = new Block(data, previousHash);
            data = data;
            timeStamp = System.currentTimeMillis();
            previousHash = previousHash;
            hash = block.calculateHash();
            return block;
        }
    }
}
