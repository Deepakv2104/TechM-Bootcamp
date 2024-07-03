var result;
result = "Tehith";
console.log("Result as a string: " + result);
result = 240;
console.log("Result as a number: " + result);
function logType(value) {
    if (typeof value == "string") {
        console.log("The type of the value is: string");
    }
    else if (typeof value == "number") {
        console.log("The type of the value is: number");
    }
    else if (typeof value == "boolean") {
        console.log("The type of the value is: boolean");
    }
}
logType("Tehith");
logType(240);
logType(true);
