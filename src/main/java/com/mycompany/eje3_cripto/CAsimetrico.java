import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

public class CAsimetrico {
    public static void main(String[] args) throws Exception {
        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        
        // Se solicita al usuario ingresar la cadena a encriptar
        System.out.println("Ingrese la cadena a encriptar:");
        String cadena = sc.nextLine();
        
        // Se genera un par de claves pública y privada con el algoritmo RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Tamaño de la clave RSA en bits
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();
        
        // Se firma la cadena utilizando la clave privada
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(cadena.getBytes());
        byte[] signedData = signature.sign();
        System.out.println("Cadena encriptada: " + new String(signedData));
        
        // Se verifica la firma utilizando la clave pública
        signature.initVerify(publicKey);
        signature.update(cadena.getBytes());
        boolean verified = signature.verify(signedData);
        if (verified) {
            System.out.println("Firma verificada, cadena desencriptada: " + cadena);
        } else {
            System.out.println("Firma no válida");
        }
    }
}
