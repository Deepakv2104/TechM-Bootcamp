function combine(flag:boolean,num:number):boolean|number{
    return flag ? num : flag;
}

console.log(combine(true,240));
console.log(combine(false,40));