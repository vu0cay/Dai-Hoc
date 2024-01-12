#include <stdio.h>

#define Max 100
#define Max_E 100
typedef struct
{
	int n,m; // so dinh va so canh
	int A[Max_E][Max_E];
} Graph;
// khoi tao do thi
void init_Graph(Graph *G, int n)
{
	int i,j;
	G->n = n;
	for(i = 1; i<=G->n; i++)
	{
		for(j = 1; j<=G->n; j++)
		{
			G->A[i][j] = 0;
		}
	}
}
void add_Edge(Graph *G, int x, int y)
{
	G->A[x][y] = 1;
	G->A[y][x] = 1;
}
int adjacent(Graph *G, int x, int y)
{
	return G->A[x][y] == 1 && G->A[y][x] == 1;
}
int degree(Graph *G, int x)
{
	int e, deg = 0;
	for(e = 1; e<=G->n; e++)
	{
		if(G->A[e][x] == 1 || G->A[x][e] == 1) deg++;
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
// in do thi dinh-dinh
void in(Graph G)
{
	int i,j; 
	for(i = 1; i<=G.n; i++)
	{
		for(j = 1; j<=G.n; j++)
			printf("%d ",G.A[i][j]);
	printf("\n");
	}
}

// in do thi dinh-cung
void in1(Graph G)
{
	int i,j; 
	for(i = 1; i<=G.n; i++)
	{
		for(j = 1; j<=G.m; j++)
			printf("%d ",G.A[i][j]);
	printf("\n");
	}
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
	in(G);	
	printf("-------------------------------------\n");
	in1(G);
	return 0;
}


