#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define ElementType int
#define Position int
typedef struct Node Node;
struct Node{
	ElementType data;
	 Node* next;
	
};

typedef Node* List;

Node *makeNode(ElementType x)
{
	Node *newnode = (Node*)malloc(sizeof(Node));
	newnode->next = NULL;
	newnode->data = x;
	
	return newnode;
}
void makeNULL(List *L)
{
	Node *newnode = (Node*)malloc(sizeof(Node));
	newnode = NULL;
	
	*L = newnode;
}
void print(List L)
{
	List p = L;
	while(p!=NULL)
	{
		printf("%d ",p->data);
		p = p->next;
	}
}


void append(ElementType x,List *L)
{
	Node *newnode = makeNode(x);
		
	if(*L == NULL)
	{
		*L = newnode;
		return;
	}
	
	List p = *L;
	while(p->next != NULL)
	{
		p = p->next;
	}
	
	p->next = newnode;
}


int Len(List L)
{
	List p = L;
	int size = 0;
	while(p!=NULL)
	{
		size++;
		p=p->next;
		
	}
	return size;
}
bool empty(List L)
{
	return (L == NULL);
}
bool fullList(List L)
{
	List p;
	p = (Node*)malloc(sizeof(Node));
	if(p!= NULL){
		free(p);
		return 0;
	}
	else return 1;
}
ElementType getAt(Position p, List L)
{
	List tmp = L;
	Position j = 0;
	while(j<p-1 && tmp!=NULL)
	{
		tmp= tmp->next;
		j++;
	}
	
	if(tmp != NULL) return tmp->data; 
	else {
		printf("in valid");
		return 0;
	}
}
Node *first(List L)
{
	List p = L;
	return p;
}
Node *endList(List L)
{
	List p = L;
	while(p->next != NULL) p = p->next;
	
	if(p!=NULL) return p;
}

void setAt(Position p, ElementType x, List *L)
{
	if(p<1 || p>Len(*L)) {
		printf("invalid \n"); 
		return;
	}

	{
			List tmp = *L;
			Node *newnode = makeNode(x);
			
			if(p == 1) {
				newnode->next = tmp->next;
				*L = newnode;
				return;
			}
			int j = 0;
			while(j<(p-1)-1 && tmp != NULL) // lay trc 1 ptu, danh sach bat dau tu 0 
			{
				j++;
				tmp = tmp->next;
			}
			
			Node *_posUpt = tmp->next;
			newnode->next = _posUpt->next;
			tmp->next = newnode;
			
			free(_posUpt);
	}
	
}
void insertFirst(ElementType x, List *L)
{
	Node *newnode = makeNode(x);
	List tmp = *L;
	newnode->next = tmp;
	*L = newnode;
}
void insertAt(Position p, ElementType x, List *L)
{
	if(p<1 || p>Len(*L)+1) {
		printf("invalid \n"); 
		return;
	}
		
	if(p == 1)
		{
			insertFirst(x,L);
			return;
		}

	List tmp = *L;
	Node *newnode = makeNode(x);

	Position j = 0;
	while(j<(p-1)-1 && tmp != NULL) // lay trc 1 ptu, danh sach bat dau tu 0 
		{
			j++;
			tmp = tmp->next;
		}
			
	Node *_posUpt = tmp->next;
	newnode->next = _posUpt;
	tmp->next = newnode;

	
}

Node *popFirst(List *L)
{
	List tmp = *L;
	*L = tmp->next;
	return tmp;
}

void popAt(Position p,List *L)
{
		
	Position j = 0;
	List tmp = *L;
	if(p == 1){
		popFirst(L);
		return;
	}
	while(j < p-1-1 && tmp!=NULL)
	{
		j++;
		tmp = tmp->next;
	}
	
	Node *_posUpt = tmp->next;
	tmp->next = _posUpt->next;
	free(_posUpt);
}
void popLast(List *L)
{
	popAt(Len(*L),L);
}
Position locate(ElementType x, List L)
{
	Position p = 0;
	List tmp = L;
	bool check = 0;
	while(tmp != NULL && getAt(p+1,L)!= x)
	{
		tmp = tmp->next;
		p++;
		if(getAt(p+1,L) == x) check = 1;
	}
	if(check) return p+1;
	else {
		printf("not found\n");
		return 0;
	}
	
}

Node *next(Position p,List L)
{
	if(p < Len(L))
	{	
		Position j = 0;
		List tmp = L;
		while(j<p-1 && tmp != NULL)
		{
			tmp = tmp->next;
			j++;
		}
		
		return tmp->next;
	} else {
		Node *newnode = makeNode(0);
		printf("not found");
		return newnode;
	}
	
}
Node *previous(Position p,List L)
{
	if(p>1)
	{
		Position j = 0;
		List tmp = L;
		while(j<p-1-1 && tmp != NULL)
		{
			tmp = tmp->next;
			j++;
		}
		 return tmp;
	}else
	{
		Node *newnode = makeNode(0);
		printf("not found");
		return newnode;
	}
	
	
}
