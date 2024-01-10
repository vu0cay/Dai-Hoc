#pragma once
#include<stdio.h>
#include<stdlib.h>
#define MAXSIZE 100

typedef int Position;
typedef int ElementType;

typedef struct{
	Position front;
	Position rear;
	ElementType elements[MAXSIZE];
	int size;
}Queue;

void makeNull(Queue *Q){
	Q->front = 0;
	Q->rear = 0;
	Q->size = 0;
} 

int isEmpty(Queue Q){
	return  Q.size == 0;
}

int isFull(Queue Q){
	return Q.size == MAXSIZE;
}

void enQueue(ElementType x, Queue *Q){
	if(!isFull(*Q)){
		Q->elements[Q->rear] = x;
		Q->rear = (Q->rear + 1) % MAXSIZE; 
		Q->size++;
		
	} else printf("QUEUE IS FULL!\n");
} 

ElementType deQueue(Queue *Q){
	if(!isEmpty(*Q)){
		ElementType x = Q->elements[Q->front];
		Q->front = (Q->front + 1) % MAXSIZE;
		Q->size--;
		return x;
	} else printf("QUEUE is Empty!\n");
}
	









