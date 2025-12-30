// Typescript we now have the ability to do static typing
// We have access to all the datatypes already in JS and some additional ones

let username: string = 'John';
let age: number = 30;
let isActive: boolean = true;
let numbers: number[] = [1, 2, 3];

// username = 34;

let flexible: any = 'Could be anything';
flexible = 43;
flexible = true;

// void (no return value)
function logMessage(): void{

}

// never (function never returns)
function throwError(): never {
    throw new Error();
}

function infiniteLoop(): never{
    while(true){}
}

// Typescript can infer the type
let inferredString = "Hello";
// inferredString = 34;

// Special Types
let u: undefined = undefined;
let n: null = null;

let maybeString: string | null = null;
maybeString = "Hello";

// Object Types
let user: {name: string, age: number, isActive?: boolean} = {
    name: "Mike",
    age: 30,
    // isActive: true
};

let config: {readonly apiKey: string; readonly endpoint: string} = {
    apiKey: '1234f',
    endpoint: 'http://api.example.com'
}

// config.apiKey = "new";


// Union Types
// This lets us allow a variable to hold values of multiple types
let id: string | number = "absc234";
id = 123;

// Type Guards
function printId(id: string | number): void {
    if(typeof id === 'string'){
        console.log(id.toUpperCase());
    }else{
        console.log(id.toFixed(2));
    }
}

let mixedArray: (string | number)[] = [1, "2", "34"];



// Type Aliases and Interfaces
// Both of these eallow you to define custom types, but with some differences

// Basic type alias
type UserId = string | number;

// Object type alias
type User = {
    id: UserId,
    name: string;
    email: string;
    age?: number;
}

// let mixedNumber: number = 3.234;
// mixedNumber = 3;
// mixedNumber = Infinity;

type GreetFunction = (name: string) => string;

let userId: UserId = "abc123";
let currentUser: User = {
    id: userId,
    name: "Mike",
    email: "mike@email.com"
}

const greet: GreetFunction = (name) => `Hello ${name}`;

// Interfaces

interface Person {
    name: string;
    age: number;
}

interface Config {
    readonly apiKey: string;
    endpoint: string;
    timeout?: number;
}

interface Employee extends Person {
    employeeId: number;
    department: string;
}

interface Employee extends Person {
    location: string;
}


// tuples
let tupleExample: [string, number] = ["name", 34];
let stringName = tupleExample[0];
let ageTuple = tupleExample[1];


// Basic Generic Array
const numbersGeneric: Array<number> = [1, 23, 4];
const stringsGeneric: Array<string> = ["a", "b", "c"];

function getFirstElement<T>(arr: T[]): T {
    return arr[0];
}

const firstNumber = getFirstElement(numbersGeneric);
const firstString = getFirstElement(stringsGeneric);