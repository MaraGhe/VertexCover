Proiect Vertex Cover realizat de Epure Amalia-Elena, Gheorghe Mara, Grosulescu Despina
Facultatea de Automatica si Calculatoare, Universitatea Politehnica din Bucuresti

Testele au fost construite cu scopul de a adresa diverse tipuri de grafuri

I. Teste pentru grafuri cu componente izolate
    // se asigura ca programul nu include noduri izolate in solutie
    1. un singur nod
    2. mai multe noduri, toate izolate
    3. 3 componente izolate: 2 subgrafuri conexe si un nod izolat

II. Teste pentru grafuri cu structura speciala
    // se observa comportamentul programului in situatii specifice
    4. graf mare in forma de linie
    5. graf in forma de cerc
    6. arbore echilibrat
    7. arbore neechilibrat

III. Teste pentru alte tipuri de grafuri
    // se observa comportamentul programului pentru grafuri conexe oarecare si grafuri absolute
    8. graf conex mic
    9. graf conex mediu
    10. graf conex mare
    11. graf absolut mic
    12. graf absolut mare


Raspunsuri exacte pentru grafurile cu multe varfuri, pentru care metoda Backtracking depaseste limita de timp:

test_4_large_line_graph:
10
2 4 6 8 10 12 14 16 18 20

test_10_large_connected_graph:
11
2 3 6 7 10 11 12 13 14 17 19

test_12_large_complete_graph:
19
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19

Specificatiile sistemului de calcul pe care au fost rulate testele:
    Sistem de operare: Windows Subsystem for Linux - Ubuntu WSL for Windows 10
    Procesor: AMD Ryzen 5 4500U cu frecventa de baza de 2,38 GHz
    Memorie disponibila: 15,4/16 GB la viteza de 3200 MHz