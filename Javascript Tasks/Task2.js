var num=parseInt(prompt("Enter the Number"))
var result=1;
for(let i=1;i<=num;i++){
    result=result*i;
}
document.write("The factorial of " + num + " is " + result);