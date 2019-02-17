package com.sucre.algorithm.medium_problem;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private int seq = 0;
    private Queue<CatDog> dogs = new LinkedList<>();
    private Queue<CatDog> cats = new LinkedList<>();


    //1.用户可以调用add方法将cat类或dog类的 实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列 的先后顺序依次弹出
    public void add(Pet pet){
        if(pet == null){
            throw new RuntimeException("error");
        }
        if ("cat".equals(pet.getPetType())) {
            cats.add(new CatDog(pet, ++seq));
        } else {
            dogs.add(new CatDog(pet, ++seq));
        }
    }

    public CatDog pollAll(){
        if (dogs.size() == 0 && cats.size() == 0) throw new RuntimeException();
        if (dogs.size() == 0){
            return cats.poll();
        }
        if(cats.size() == 0){
            return dogs.poll();
        }
        if (dogs.peek().getSeq() < cats.peek().getSeq()){
            return dogs.poll();
        }else{
            return cats.poll();
        }
    }
    //2.用户可以调用pollDog方法，将队列中dog类的实例按照 进队列的先后顺序依次弹出；
    public CatDog pollDog(){
        if (dogs.size() == 0) throw new RuntimeException("error");
        return dogs.poll();
    }
    //3.用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出；
    public CatDog pollCat(){
        if (cats.size() == 0) throw new RuntimeException("error");
        return cats.poll();
    }
    //4.用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例；
    public boolean isEmpty(){
        if (dogs.size() != 0 && cats.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
    //5.用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例；
    public boolean isDogEmpty(){
        if (dogs.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
    //6.用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
    public boolean isCatEmpty(){
        if (cats.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
    public Queue<CatDog> getDogs() {
        return dogs;
    }


    public Queue<CatDog> getCats() {
        return cats;
    }

}
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}


class CatDog{
    /*
    声明一个表示序号的变量和一个表示类型的引用
     */
    private int seq = 0;
    private Pet pet;

    public CatDog(Pet pet, int seq) {
        this.pet = pet;
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public Pet getPet(){
        return this.pet;
    }
}
