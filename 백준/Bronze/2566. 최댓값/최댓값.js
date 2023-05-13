const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let n;
let m;

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{

    let x=-1;
    let a=-1;
    let b=-1;

    for(let i=0;i<9;i++){
        for(let j=0;j<9;j++){
            if(x<input[i][j]){
                a=i;
                b=j;
                x=input[i][j];
            }
        }
    }
    //console.log(input[0][0].length);
    //arr.map((er)=>process.stdout.write(er+" "));
    console.log(x);
    console.log(a+1,b+1);
    
    process.exit();
}) 
