#include <Servo.h>

Servo m1;
Servo m2;
Servo m3;
Servo m4;

Servo s1;
Servo s2;
Servo s3;
Servo s4;

char buffer[16]; //16 Hexademcimal Inputs, 2 (a signed byte) per motor channel

void setup() {

        m1.attach(1);
        m2.attach(2);
        m3.attach(3);
        m4.attach(4);

        s1.attach(5);
        s2.attach(6);
        s3.attach(7);
        s4.attach(8);

        //reset motors and servos at startN\
        m1.write(127);
        m2.write(127);
        m3.write(127);
        m4.write(127);

        s1.write(90);
        s2.write(90);
        s3.write(90);
        s4.write(90);

        Serial.begin(9600); //rate that arduino communicates with processing
        
        
}

void loop() {
  while(Serial.available() > 16) { //gather 17 bits in hardware buffer
     
        byte message = Serial.read();

        if (message == 'T' || message == 't') { //True if connected followed by 16 Hexadecimal inputs
                
                for(int i=0; i < 16; i++) {
                        buffer[i] = Serial.read();
                }       
                Serial.write(buffer);
                //Convert two hexes to a decimal 0~255
                //center value is 127
                

                m1.write((hex2dec(buffer[0]) * 16 + hex2dec(buffer[1])));
                m2.write((hex2dec(buffer[2]) * 16 + hex2dec(buffer[3])));
                m3.write((hex2dec(buffer[4]) * 16 + hex2dec(buffer[5])));
                m4.write((hex2dec(buffer[6]) * 16 + hex2dec(buffer[7])));

                s1.write((hex2dec(buffer[8]) * 16 + hex2dec(buffer[9])));
                s2.write((hex2dec(buffer[10]) * 16 + hex2dec(buffer[11])));
                s3.write((hex2dec(buffer[12]) * 16 + hex2dec(buffer[13])));
                s4.write((hex2dec(buffer[14]) * 16 + hex2dec(buffer[15])));
        }

  }
} 
 //when called above, it will convert the character read from processing to a number 
byte hex2dec(byte c) { //c is the character that was buffered
        if (c >= '0' && c <= '9') {
                return c - '0';
        }       
        else if (c >= 'A' && c <= 'F') {
                return c - 'A' + 10;
        }       
        else if (c >= 'a' && c <= 'f') {
                return c - 32 - 'A' + 10;
        }       
}
