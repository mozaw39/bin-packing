# bin-packing
"In the bin packing problem, items of different volumes must be packed into a finite number of bins or containers each of a fixed given volume in a way that minimizes the number of bins used. In computational complexity theory, it is a combinatorial NP-hard problem. The decision problem is NP-complete." Wikipedia
# The used Algorithm
"First-Fit is an AF-algorithm that processes the items in a given arbitrary order L. For each item in L, it attempts to place the item in the first bin that can accommodate the item. If no bin is found, it opens a new bin and puts the item within the new bin." Wikipedia <br/>
The approach used here is called First-Fit-Decreasing, that is we sort the items that we have in a decreasing order (comparing the surface).
# Class Diagram
![classDiag](https://github.com/mozaw39/bin-packing/blob/main/project-diags/BinPacking3D.png)
# Explication of classes in the real world
## BookList & BookLevel
![explication](https://github.com/mozaw39/bin-packing/blob/main/project-diags/RealWord_Classes.png)
## BookMatrice & BookList
BookMatrice is the assembly of the BookList to fill the container
![explication1](https://github.com/mozaw39/bin-packing/blob/main/project-diags/RealWorld_classes_3D.png)
10
