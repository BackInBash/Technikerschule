;
; Bool.asm
;
; Created: 12/03/2021 14:30:26
; Author : Markus
;


; Replace with your application code

init:
	ldi R16, 4	 ; Initialisiere R16 mit 4
	ldi R17, 17  ; Initialisiere R17 mit 17

start:
    add R17, R16  ; Addiere R16 mit R17 und speichere ergebnis in R17
	mov R1, R17   ; Kopiere wert von R17 nach R1
	out PORTA, R1 ; Setze wert von R1 nach PORTA
    ;rjmp start
