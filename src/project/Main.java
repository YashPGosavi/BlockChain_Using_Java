package project;

public class Main {
    public static void main(String[] args) {
        // Initialize blockchain with the genesis block
        BlockChain.blockChain.add(new Block("0"));

        // Create some transactions
        BlockChain.createTransaction(new Transaction("Alice","Bob",50));
        BlockChain.createTransaction(new Transaction("Bob","Charlie",25));

        // Mine pending transactions with miner's address "Miner1"
        System.out.println("Mining Block...");
        BlockChain.minePendingTransactions("Miner1");

        // Display the balance of Miner1
        System.out.println("balance of Miner1: " + BlockChain.miningReward);

        // Mine another block with more transactions
        BlockChain.createTransaction(new Transaction("Alice","Bob",30));
        BlockChain.createTransaction((new Transaction("Bob","ALice",20)));

        System.out.println("Mining another block");
        BlockChain.minePendingTransactions("Miner1");

        System.out.println("Balance of Miner1 after second mining: " + BlockChain.miningReward);

        // validate the blockchain
        System.out.println("Bolckchain is valid: " + BlockChain.isChainValid());
    }
}

