package springsecurity.config;

import org.bouncycastle.asn1.iso.ISOIECObjectIdentifiers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

import javax.crypto.KeyGenerator;
import java.util.Arrays;

/**
 * In order to remember, this class is only to practice SSCM, it is not part of the project
 */
@Configuration
public class SscmExample {

    private int flag = 0;

    @Bean
    public void generateKeyWithStringKeyGenerator(){
        StringKeyGenerator keyGenerator = KeyGenerators.string();
        String salt = keyGenerator.generateKey();
        System.out.println("********" + salt);
    }

    @Bean
    public void generateKeyWithByteKeyGenerator(){
        BytesKeyGenerator keyGenerator = KeyGenerators.secureRandom();
        byte[] key = keyGenerator.generateKey();
        int keyLength = keyGenerator.getKeyLength();
        System.out.println("---------" + key.toString() + " - " + keyLength);
    }

    @Bean
    public void generateKeyWithByteKeyGenerator16(){
        BytesKeyGenerator keyGenerator = KeyGenerators.secureRandom(16);
        byte[] key = keyGenerator.generateKey();
        int keyLength = keyGenerator.getKeyLength();
        System.out.println("---------" + key.toString() + " - " + keyLength);
    }

    @Bean
    public void generateKeyWithByteGeneratorShared(){
        BytesKeyGenerator keyGenerator = KeyGenerators.shared(16);
        while(flag <= 2){

            byte[] key1 = keyGenerator.generateKey();
            byte[] key2 = keyGenerator.generateKey();
            int keyLength = keyGenerator.getKeyLength();
            System.out.println("................." + key1.toString() + " - " + " - " + key2.toString() + " - "+ keyLength);
            flag++;
        }
    }

    @Bean
    public void generateEncriptorExample(){
        String salt = KeyGenerators.string().generateKey();
        String password = "M4r14n40611@";
        String valueToEncrypt = "6270561-820217780";

        BytesEncryptor e = Encryptors.stronger(password, salt);
        byte[] encrypted = e.encrypt(valueToEncrypt.getBytes());
        System.out.println("1.) " + encrypted);
        byte[] decrypted = e.decrypt(encrypted);
        System.out.println("2.) " + new String(decrypted, 0));
    }

    @Bean
    public void generateEncryptorExample(){
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "hello";

        TextEncryptor e = Encryptors.text(password, salt);
        String encrypted = e.encrypt(valueToEncrypt);
        String encrypted2 = e.encrypt(valueToEncrypt);
        //To remember each call to the method encrypt either Encryptor.text or Encryptor.deluxe it generate different values
        //For this reason I created the method bellow to use Encryptors.queryableText that generate the same output in each call
        System.out.println("3.) " + encrypted + " - " + encrypted2);
        String decrypted = e.decrypt(encrypted);
        System.out.println("4.) " + decrypted);

    }

    @Bean
    public void generateQueryAbleExample(){
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "hello";

        TextEncryptor e = Encryptors.queryableText(password, salt);
        String encrypted = e.encrypt(valueToEncrypt);
        String encrypted2 = e.encrypt(valueToEncrypt);
        System.out.println("5.) " + encrypted + " - " + encrypted2);
        String decrypted = e.decrypt(encrypted);
        System.out.println("6.) " + decrypted);

    }


}
