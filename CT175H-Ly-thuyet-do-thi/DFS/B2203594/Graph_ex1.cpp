#include <stdio.h>

#define nmax 100
typedef struct
{
	int x,y; // 1 cung
}  	Egde;
typedef struct
{
	int n,m; // so dinh va so canh
	Egde egdes[nmax];
} Graph;
// khoi tao do thi
void init_Graph(Graph *G, int n)
{
	G->n = n; // so dinh = so dinh khoi tao
	G->m = 0; // ban dau tap cung la rong
}
void add_Edge(Graph *G, int x, int y)
{
	// them cap cung x,y vao tap edges
	G->egdes[G->m].x = x;	
	G->egdes[G->m].y = y;
	//tang kich thuoc m len 1 cho lan them tiep theo
	G->m++;
}
int adjacent(Graph *G, int x, int y)
{
	int e;
	int check = 0;
	for(e = 0; e< G->m; e++)
	{
		if(G->egdes[e].x == x && G->egdes[e].y == y
			|| G->egdes[e].x == y && G->egdes[e].y == x)
		{
			check = 1;
			break;
		}
	}
	return check;
}
int degree(Graph *G, int x)
{
	int e, deg = 0;
	for(int e = 0; e <= G->m; e++)
	{
		if(G->egdes[e].x == x) deg++;
		if(G->egdes[e].y == x) deg++;
	}
	
	return deg;
}
void neighbours(Graph *G, int u)
{
	int v;
	for(int v = 1; v<=G->n; v++)
		if(adjacent(G,u,v) != 0 )
			printf("%d ",v);
		printf("\n");
	
}


int main()
{
	Graph G;
	int n,m;
	FILE *f = fopen("do_thi.txt","r");
	fscanf(f,"%d%d", &n, &m);
	init_Graph(&G,n);
	int u,v,e;
	for( e = 1; e <= m; e++)
	{
		fscanf(f, "%d%d", &u,&v);
		add_Edge(&G,u,v);
	}
	int i,j;
	for(i = 1; i<=G.n; i++) 
		printf("Degree(%d): %d\n",i,degree(&G,i));
	printf("-------------------------------------\n");
	int a; 
	for(a = 1; a<=G.n; a++)
		for(j = 1; j<= G.n; j++)
		{
			if(adjacent(&G,a,j) == 1) printf("%d ke %d\n",a,j);
			else printf("%d khong ke %d\n",a,j);
		}
	printf("-------------------------------------\n");
	
	for(i = 1; i<=G.n; i++)
	{
		printf("neighbours cua %d la: ",i);
		neighbours(&G,i);
		printf("\n");
	}
			

	return 0;
}


