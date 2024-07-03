var n=parseInt(prompt("Enter the Number"))
var flag=false;
if(n==1)
    document.write("1 is neither Prime nor Consonant");
for(let i=2;i<=Math.sqrt(n);i++){
    if(n%i==0){
        document.write(n + " is not a Prime Number");
        flag=true;
        break;
    }
}
if(flag==false)
    document.write(n + " is a Prime Number");