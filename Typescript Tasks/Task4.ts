type Student={
    roll:number,
    name:string,
    age:number,
    classs:string
};

var stud:Student={
    roll:240,
    name:"Tehith",
    age:240,
    classs:"AI"
};
function printDetails(stud:Student){
    console.log("Roll No: " + stud.roll);
    console.log("Name: " + stud.name);
    console.log("Age: " + stud.age);
    console.log("Class: " + stud.classs); 
}
console.log(stud);
printDetails(stud);

