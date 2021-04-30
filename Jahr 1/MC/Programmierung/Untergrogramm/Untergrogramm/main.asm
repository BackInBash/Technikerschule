;
; Untergrogramm.asm
;
; Created: 30/04/2021 14:08:58
; Author : Markus
;


; Programmcode mit einem Hauptprogramm und einem Unterprogramm
; Folgen Sie den Anweisungen auf dem Arbeitsblatt

; Programmcode
initialisierung:
	ldi r16, high(Ramend);
	out SPH, r16;
	ldi r16, low(Ramend);
	out SPL, r16;
	ldi R17,00;

Hauptprogramm:
	inc r17
	call wait16cycles
	rol r17
	call wait16cycles
	jmp Hauptprogramm

.def timer = R20
wait16cycles: 
	ldi timer, 3
	schleifenkopf:
		nop
		dec timer
	brbc SREG_Z, schleifenkopf
ret