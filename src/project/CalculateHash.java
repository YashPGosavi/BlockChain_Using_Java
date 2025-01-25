package project;

import java.security.*;
public class CalculateHash {
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte [] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexaDecimalString = new StringBuffer();
            for (int i=0;i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1){
                    hexaDecimalString.append('0');
                }
                    hexaDecimalString.append(hex);
            }
            return  hexaDecimalString.toString();
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}








































/*
import java.security.MessageDigest;
        This line imports the MessageDigest class from the java.security package. MessageDigest is used to generate hash values, which are fixed-length representations of data used for secure hashing, such as SHA-256.

MessageDigest digest = MessageDigest.getInstance("SHA-256");
        In this try block, a MessageDigest object called digest is created by calling MessageDigest.getInstance("SHA-256"), which specifies that SHA-256 should be used as the hashing algorithm.

byte[] hash = digest.digest(input.getBytes("UTF-8"));
        This line converts the input string into a byte array (using UTF-8 encoding) and passes it to the digest method, which processes the bytes and generates a SHA-256 hash. The result is stored in the hash byte array.

byte[] hash = digest.digest(input.getBytes("UTF-8"));
        This line converts the input string into a byte array (using UTF-8 encoding) and passes it to the digest method, which processes the bytes and generates a SHA-256 hash. The result is stored in the hash byte array.

StringBuffer hexaDecimalString = new StringBuffer();
        Here, a StringBuffer named hexaDecimalString is created to build the hexadecimal representation of the SHA-256 hash. StringBuffer is used because it’s efficient for appending strings in loops.

for (int i = 0; i < hash.length; i++) {
        A for loop iterates over each byte in the hash array. hash.length gives the number of bytes in the hash, and each byte will be processed to generate its hexadecimal representation.

String hex = Integer.toHexString(0xff & hash[i]);
        In this line, each byte in the hash array is converted to a hexadecimal string. The 0xff & hash[i] expression masks out any leading sign bits, ensuring the byte value is always treated as positive. Integer.toHexString then converts it to hexadecimal format.

if (hex.length() == 1) {
    hexaDecimalString.append('0');
}
        If the hexadecimal string hex has only one character (like "f" instead of "0f"), a leading '0' is appended to hexaDecimalString to ensure two-digit hexadecimal representation for each byte.

hexaDecimalString.append(hex);
        If hex has two characters, it is appended directly to hexaDecimalString.
 */