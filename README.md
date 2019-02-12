# FileMagicNumber

Z tego co udało mi się zauważyć, w plikach tekstowych nie ma jasno określonej magicznej liczby. Na liście znalazłem jedynie
"UTF-8 encoded Unicode byte order mark, commonly seen in text files", ale nie definiuje on jednoznacznie czy plik jest tekstowy.
Poprawiłem program, żeby interpretował BOM (więc już nie wyrzuci błędu z JPG).

według https://stackoverflow.com/questions/23672780/magic-number-for-plain-text-file
"Magic numbers do not make sense for plain text files. If you write a magic number to the file, it would no longer be a plain text file. 
It would be a file that follows your format which might be a magic number followed by a bunch of plain text."
Przychodzi mi do głowy, że możnaby sprawdzać właśnie coś z kodowaniem/poprawnością znaków w samym tekscie.
