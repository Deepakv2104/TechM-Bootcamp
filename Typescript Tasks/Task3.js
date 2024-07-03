var unknown = "1234";
var str = unknown;
console.log("The value of unknown " + unknown);
console.log("The type of unknown " + typeof unknown);
console.log("The value of str " + str);
console.log("The type of str " + typeof str);
var n = 1234;
var s = n.toString(); //let s:string=n.toString();
console.log("The value of n " + n);
console.log("The type of n " + typeof n);
console.log("The value of s " + s);
console.log("The type of s " + typeof s);
var numString = "1234";
var numValue = parseInt(numString); //let numValue:number=parseInt(numString);
console.log("The value of numString " + numString);
console.log("The type of numString " + typeof numString);
console.log("The value of numValue " + numValue);
console.log("The type of numValue " + typeof numValue);
// // TypeScript Program to demonstrate type assertions and type conversions
// // Type assertion: Convert a variable from 'unknown' to 'string'
// let unknownVariable: unknown = "1234";
// let strVariable: string = unknownVariable as string;
// console.log("Type assertion from unknown to string:", strVariable);
// // Type conversion: Convert a string to a number using parseInt()
// let numericString: string = "5678";
// let numberVariable: number = parseInt(numericString, 10);
// console.log("Type conversion from string to number using parseInt():", numberVariable);
// // Type assertion: Convert a variable from 'any' to 'boolean'
// let anyVariable: any = "true";
// let boolVariable: boolean = (anyVariable as string).toLowerCase() === "true";
// console.log("Type assertion from any to boolean:", boolVariable);
// // Type conversion: Convert a number to a string using toString()
// let numValue: number = 12345;
// let strValue: string = numValue.toString();
// console.log("Type conversion from number to string using toString():", strValue);
// // Type assertion: Convert a variable from 'unknown' to 'number'
// let anotherUnknownVariable: unknown = 9876;
// let anotherNumberVariable: number = anotherUnknownVariable as number;
// console.log("Type assertion from unknown to number:", anotherNumberVariable);
// // Type conversion: Convert a boolean to a string using String()
// let booleanValue: boolean = false;
// let booleanToString: string = String(booleanValue);
// console.log("Type conversion from boolean to string using String():", booleanToString);
