package project;

import java.util.ArrayList;
import java.util.Date;
public class Block {
    // Digital Signature = hash
    public String hash;
    public String previousHash;
    private long timeStamp;
    private int nonce;
    
    public ArrayList<Transaction> transactions = new ArrayList<>();

    public Block(String previousHash){
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();  // calculating hash values
    }


    // add transaction to the block
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public String calculateHash(){
        String transactionData = transactions.toString();
        String calculatehash = CalculateHash.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        transactionData
        );
        return calculatehash;
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0','0');
        while (!hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined : " + hash);
    }

}



























// a Single Block in blockChain contains data,hash of previous block
// and for next new block we have to create a new digital signeture by using previous hash , new data and timeStamp


