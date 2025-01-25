package project;

import java.util.ArrayList;

public class BlockChain {
    public static ArrayList<Block> blockChain = new ArrayList<>();
    public static int difficulty =5;
    public static ArrayList<Transaction> pendingTransactions = new ArrayList<>();
    public static float miningReward = 10;

    // Create a new transaction and add it to the pending transactions
    public static void createTransaction(Transaction transaction){
        pendingTransactions.add(transaction);
    }


    // Mine pending transactions, adding them to a new block
    public static void minePendingTransactions(String minerAddress){
        Block newBlock = new Block(blockChain.get(blockChain.size() - 1).hash);

        // Add all pending transactions to the block
        for (Transaction transaction : pendingTransactions){
            newBlock.addTransaction(transaction);
        }

        // Reward the miner by creating a transaction for the mining reward
        Transaction rewardTransaction = new Transaction("System",minerAddress,miningReward);
        newBlock.addTransaction(rewardTransaction);

        // Mine the block
        newBlock.mineBlock(difficulty);
        blockChain.add(newBlock);

        // Clear pending transactions (we assume all have been added to the mined block)
        pendingTransactions.clear();
    }

    public static boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0','0');

        for (int i=1;i<blockChain.size();i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            // Check if current block's hash is correct
            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Error: Current block hash does not match calculated hash for block " + i);
                return false;
            }

            // Check if previous block's hash is correct
            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Error: Previous block hash does not match stored previous hash for block " + i);
                return false;
            }

            // Check if hash is solved
            if(!currentBlock.hash.substring(0,difficulty).equals(hashTarget)){
                System.out.println("Error: Block has not been mined to the specified difficulty for block " + i);
                return  false;
            }

        }
        return true;
    }

//    public static void addBlock(Block newBlock) {
//        newBlock.mineBlock(difficulty);
//        blockChain.add(newBlock);
//    }
}
