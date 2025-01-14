Proiect Vertex Cover realizat de Epure Amalia-Elena, Gheorghe Mara, Grosulescu Despina
Facultatea de Automatica si Calculatoare, Universitatea Politehnica din Bucuresti

Testele au fost construite cu scopul de a adresa diverse tipuri de grafuri

I. Teste pentru grafuri fara muchii (edge case)
    // se asigura ca programul nu inventeaza noduri/muchii
    1. graf nul
    2. 5 noduri izolate
    3. 20 noduri izolate

II. Teste pentru grafuri oarecare cu componente izolate
    // sunt testate grafuri compuse din diferite subgrafuri izolate
    4. 2 subgrafuri conexe cu 4, respectiv 2 noduri si un nod izolat
    5. 3 subgrafuri complete cu cate 3 noduri fiecare
    6. 2 subgrafuri complete cu 5, respectiv 4 noduri
    7. un nod izolat si 5 subgrafuri conexe cu 2, 3, 4, 5, 5 noduri

III. Teste pentru grafuri conexe cu numar mic de muchii
    // cazuri in care solutia reala contine aproximativ jumatate din numarul nodurilor
    8. graf in forma de linie cu 5 noduri
    9. graf in forma de linie cu 10 noduri
    10. graf in forma de linie cu 20 noduri
    11. graf circular cu 10 noduri
    12. graf circular cu 20 noduri

IV. Teste pentru arbori
    // se testeaza comportamentul algoritmilor in aplicatii ce se folosesc de arbori
    13. arbore echilibrat (diferenta dintre inaltimile subarborelor unui nod nu depaseste 1)
    14. arbore neechilibrat (diferenta mentionata e mai mare de 1)
    15. padure cu 2 arbori: unul echilibrat cu multe frunze si altul neechilibrat cu multe noduri parinte

V. Teste pentru grafuri conexe oarecare
    // sunt testate diferite grafuri conexe
    16. graf mic cu 5 noduri si 5 muchii
    17. graf mediu cu 9 noduri si 11 muchii
    18. graf mare cu 20 noduri si 26 muchii

VI. Teste pentru grafuri complete
    // cazuri in care solutia contine aproape nodurile mai putin unul
    19. graf complet mic cu 5 noduri
    20. graf complet mare cu 20 noduri

Raspunsuri exacte pentru grafurile cu multe varfuri, pentru care metoda Backtracking depaseste limita de timp:

test_7_separate_components_4:
9
2 6 7 10 11 12 16 17 19

test_10_line_graph_large:
10
2 4 6 8 10 12 14 16 18 20

test_12_circular_graph_large:
10
1 3 5 7 9 11 13 15 17 19

test_15_tree_multiple:
6
1 2 12 14 16 19

test_18_connected_graph_large:
11
2 3 6 7 10 11 12 13 14 17 19

test_20_complete_graph_large:
19
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19

Specificatiile sistemului de calcul pe care au fost rulate testele:
    Sistem de operare: Windows Subsystem for Linux - Ubuntu WSL for Windows 10
    Procesor: AMD Ryzen 5 4500U cu frecventa de baza de 2,38 GHz
    Memorie disponibila: 15,4/16 GB la viteza de 3200 MHz