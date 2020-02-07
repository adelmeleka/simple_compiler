HMINSEC Start 0
EXTREF XREAD,XWRITE
STL RETADR
j {EXADDR}
RETADR RESW 1
hours RESW 1
convert_to RESW 1
mins RESW 1
secs RESW 1
sixity RESW 1
{EXADDR} LDA #0
+JSUB XREAD
WORD 2
WORD hours
WORD convert_to
LDA hours
MUL sixity
STA mins
MUL sixity
STA secs
+JSUB XWRITE
WORD 2
WORD mins
WORD secs
LDL RETADR
RSUB
END
