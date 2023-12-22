const MORSE_CODE = { 
    '.-':     'A',
    '-...':   'B',
    '-.-.':   'C',
    '-..':    'D',
    '.':      'E',
    '..-.':   'F',
    '--.':    'G',
    '....':   'H',
    '..':     'I',
    '.---':   'J',
    '-.-':    'K',
    '.-..':   'L',
    '--':     'M',
    '-.':     'N',
    '---':    'O',
    '.--.':   'P',
    '--.-':   'Q',
    '.-.':    'R',
    '...':    'S',
    '-':      'T',
    '..-':    'U',
    '...-':   'V',
    '.--':    'W',
    '-..-':   'X',
    '-.--':   'Y',
    '--..':   'Z',
    '.----':  '1',
    '..---':  '2',
    '...--':  '3',
    '....-':  '4',
    '.....':  '5',
    '-....':  '6',
    '--...':  '7',
    '---..':  '8',
    '----.':  '9',
    '-----':  '0',
};

// function decodeMorse(morseCode){
//     let out = "", re = true;
//     for(char of morseCode.split(/  | /)){
//         if(char==""){
//             if(re)out+=" ";
//             re = false;
//         }else{
//             out+=MORSE_CODE[char];
//             re = true;
//         }
//     }
//     return out.trim();
// }

const decodeMorse = a => a.trim().split("   ").map(b=>b.split(" ").map(c=>MORSE_CODE[c]).join("")).join(" ");
const code = " .... . -.--   .--- ..- -.. . ";
document.write("-Morse: "+code+"<br>");
document.write("-English: "+decodeMorse(code));