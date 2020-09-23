function solution(arr) {
    return arr.reduce((acc,num)=>acc+num,0)/arr.length;
}