#include <Servo.h>

Servo s[12];

char buffer[25];

void setup() {
  for(int i = 0; i < 12; i++){
    s[i].attach(i+2);
    //s[i].write(0);
  }
  delay(1000); // for ESCs
  //s[0].writeMicroseconds(1460);
  //s[1].writeMicroseconds(1460);
  Serial.begin(115200);
}

void loop() {
  while(Serial.available() == 25){
    Serial.readBytes(buffer, Serial.available());
    if(buffer[0] == 'T'){

      //ESCs
      //s[0].writeMicroseconds(i2ms((hex2dec(buffer[0]) * 16) + hex2dec(buffer[1])));
      //s[1].writeMicroseconds(i2ms((hex2dec(buffer[2]) * 16) + hex2dec(buffer[3])));
      float s1d = ((hex2dec(buffer[1]) * 16) + hex2dec(buffer[2]))/200;
      float s2d = ((hex2dec(buffer[3]) * 16) + hex2dec(buffer[4]))/200;
      
      s[0].write(s1d*160);
      s[1].write(s2d*160);
      for(int i = 2; i < 12; i++){
        int b = i * 2;
        b = b+1;
        s[i].write((hex2dec(buffer[b]) * 16) + hex2dec(buffer[b+1]));
        //s[i].writeMicroseconds(d2ms((hex2dec(buffer[b]) * 16) + hex2dec(buffer[b+1])));
      }
    }
  }
}

int i2ms(int d){
  return  1060 + (4*d);
}

int hex2dec(char c) { //c is the character that was buffered
  if(c == '0'){
    return 0;
  } else if(c == '1'){
    return 1;    
  } else if(c == '2'){
    return 2;    
  } else if(c == '3'){
    return 3;    
  } else if(c == '4'){
    return 4;    
  } else if(c == '5'){
    return 5;    
  } else if(c == '6'){
    return 6;    
  } else if(c == '7'){
    return 7;    
  } else if(c == '8'){
    return 8;    
  } else if(c == '9'){
    return 9;    
  } else if(c == 'A'){
    return 10;    
  } else if(c == 'B'){
    return 11;    
  } else if(c == 'C'){
    return 12;    
  } else if(c == 'D'){
    return 13;    
  } else if(c == 'E'){
    return 14;    
  } else if(c == 'F'){
    return 15;    
  } else {
    return 0;
  }
}
