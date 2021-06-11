;
; Taster.asm
;
; Created: 11.06.2021 13:52:48
; Author : markus.brunsch
;


; Replace with your application code
init:
	ldi R16,0x00
	out DDRA,R16

main:
	in  R17, PINA					; Read PINA Value
	andi R17, 0b00000100			
	cpi R17, 4						; Compare Value
	brbc 1, main					; Jump to Loop or Counter

	count_car:
		inc R18						; Increase Counter
		loop:
			in  R17, PINA
			andi R17, 0b00000100
			cpi R17, 4
			brbs 0, main			; If R17 is zero jump back to main
			rjmp loop