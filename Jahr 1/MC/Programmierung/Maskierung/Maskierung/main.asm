;
; Maskierung.asm
;
; Created: 07/05/2021 14:26:56
; Author : Markus
;

.INCLUDE    "m16def.inc"

init:
	; Setup Bit-Mask
	LDI R16, 0b00001111 ; low-nibbl Mask
	LDI R17, 0b11110000 ; high-nibbl Mask

	LDI R18, 0 ; Register for low nibbl mask
	LDI R19, 0 ; Register for high nibbl mask
	

	LDI R20, 0xff ; Initialize PORTA
	out DDRA, R20

	LDI R21, 0x00 ; Initialize PORTB
	out DDRB, R21
	

main:
    in R18, PORTA ; Save PORTA Results
	in R19, PORTA

	AND R18, R16 ; Mask Results
	AND R19, R17

	ADD R18, R19 ; Add both results

	out PORTB, R18 ; Write results to PORTB