ID: 48051462
NAME: Mollie Hamman
                                                        for N=10000
for both insertion and search:      2log(N)             2log(10000) = 26.5754248
for insertion:                      log(N)              log(10000)  = 13.2877124
for search:                         log(N)              log(10000)  = 13.2877124

Analysis:
Once 10,000 products are inserted into a tree, there are roughly 13 levels to it, making insertion or search log(N).
Worst case (being that the product is at the bottom of the tree) is that you have to descend the tree down 13 levels in order to find or insert a product.

![Insertion Output]("Insertion.png")
![Search Output]("Search.png")

OUTPUT:
* * * Menu * * *
I - Insertion
S - Search
X - Exit
Enter Choice: I

Inserting Product:
UserID: 3932387affc268b3c9d6cca70dbdbcb4
Name: roblox toy
Category: Toys & Games
Price: $39.39
Insertion successful.

Inserting Product:
UserID: 93f821fa0abe44f1d29203623d5ee012
Name: jelly cat
Category: Stuffed Animals
Price: $93.93
Insertion successful.

Inserting Product:
UserID: 3932387affc268b3c9d6cca70dbdbcb4
Name: roblox toy
Category: Toys & Games
Price: $39.39
Insertion failed - Product already exists

Enter Next Choice [I,S,X]: S

Enter ID: 3932387affc268b3c9d6cca70dbdbcb4
Search found:
UserID: 3932387affc268b3c9d6cca70dbdbcb4
Name: roblox toy
Category: Toys & Games
Price: $39.39
Enter Next Choice [I,S,X]: S

Enter ID: 2bb94aefc3467ed83860e0e2712d5f10
Search found:
UserID: 2bb94aefc3467ed83860e0e2712d5f10
Name: Hasegawa Ladders Lucano Step Ladder, Orange
Category: Home & Kitchen | Furniture | Kids' Furniture | Step Stools
Price: $152.27
Enter Next Choice [I,S,X]: X

Exited Menu. Have a nice day :)
