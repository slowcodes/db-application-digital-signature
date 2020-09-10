package ng.com.bitsystems.digitalsignature.services;

public interface CipherService {
    public void setKey(String myKey);

    public  String encrypt(String strToEncrypt, String secret);

    public String decrypt(String strToDecrypt, String secret);
}
