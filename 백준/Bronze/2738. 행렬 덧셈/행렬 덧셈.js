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

    n=input[0][0];
    m=input[0][1];

    for(let i=0;i<n;i++){
        for(let j=0;j<m;j++){
            let x=input[1+i][j]+input[1+n+i][j];
            process.stdout.write(x+" ");
        }
        process.stdout.write("\n");
    }
    //console.log(input[0][0].length);
    //arr.map((er)=>process.stdout.write(er+" "));
    
    process.exit();
}) 
