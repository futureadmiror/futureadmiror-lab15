public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
  

    public Enigma(int id1, int id2, int id3, String start){
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0)); // rotorint 0  start 0 # 3 
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1)); //rotorint 1 start 1 # 2
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));// rotorint 2 start 2# 1
    }


    public String decrypt(String message){        
        char[] msg = message.toCharArray();
        String result = "";
        for (int j = 0; j < msg.length; j++){
            int i = rotors[2].indexOf(msg[j]);
            char finalChar =  rotors[1].charAt(i); 
            int idx = rotors[2].indexOf(finalChar);
            char letter =  rotors[0].charAt(idx); 
            result = result + letter; 
            rotate(); 
        } 
        return result;           
    }
    
    
    public String encrypt(String message){ // encrypt the message AAA
        //System.out.println(message);
        char[] msg = message.toCharArray();
        String result = "";
        for (int j = 0; j < msg.length; j++){
            //System.out.println(msg[j]);
            int i = rotors[0].indexOf(msg[j]);
            char letter =  rotors[2].charAt(i); 
            int idx =  rotors[1].indexOf(letter);
            char finalChar =  rotors[2].charAt(idx); 

            result = result + finalChar; //NDU
            rotate();
        } 
        return result;           
    }
 
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
