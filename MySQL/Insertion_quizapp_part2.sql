USE quizappdb;

-- Table quiz
INSERT INTO quiz (quiz_id, quiz_name, quiz_description)
VALUES
	(1, 'Math', 'To compute the simple arithmetic.'),
    (2, 'Cloze Test', 'Choice the correct letter for the word.'),
    (3, 'Sign', 'Find the same punctuation with the question.')
    
;


-- Table question
INSERT INTO question (question_id, quiz_id, question_content, question_status)
VALUES
	(1, 1, 'Compute the answer of 1 + 1 = ?', 'Adopted'),
    (2, 1, 'Compute the answer of 1 + 2 = ?', 'Adopted'),
    (3, 1, 'Compute the answer of 2 + 2 = ?', 'Adopted'),
    (4, 1, 'Compute the answer of 2 + 3 = ?', 'Adopted'),
    (5, 1, 'Compute the answer of 3 + 7 = ?', 'Adopted'),
    (6, 1, 'Compute the answer of 5 + 5 = ?', 'Adopted'),
    (7, 1, 'Compute the answer of 9 + 2 = ?', 'Adopted'),
    (8, 1, 'Compute the answer of 11 + 2 = ?', 'Adopted'),
    (9, 1, 'Compute the answer of 1 + 21 = ?', 'Adopted'),
    (10, 1, 'Compute the answer of 122 + 23 = ?', 'Adopted'),
    (11, 1, 'Compute the answer of 14 + 21 = ?', 'Adopted'),
    (12, 1, 'Compute the answer of 15 + 22 = ?', 'Adopted'),
    (13, 1, 'Compute the answer of 14 + 29 = ?', 'Adopted'),
    (14, 1, 'Compute the answer of 12 + 29 = ?', 'Adopted'),
    (15, 1, 'Compute the answer of 61 + 23 = ?', 'Adopted'),
    (16, 1, 'Compute the answer of 31 + 28 = ?', 'Adopted'),
    (17, 1, 'Compute the answer of 23 + 2 = ?', 'Adopted'),
    (18, 1, 'Compute the answer of 76 + 7 = ?', 'Adopted'),
    (19, 1, 'Compute the answer of 32 + 1 = ?', 'Adopted'),
    (20, 1, 'Compute the answer of 90 + 2 = ?', 'Adopted'),
    
    
    
    (21, 2, 'Select the correct letter for serend_pity.', 'Adopted'),
    (22, 2, 'Select the correct letter for membr_ne', 'Adopted'),
    (23, 2, 'Select the correct letter for rel_gate', 'Adopted'),
    (24, 2, 'Select the correct letter for lu_ky dog', 'Adopted'),
    (25, 2, 'Select the correct letter for compl_x', 'Adopted'),
    (26, 2, 'Select the correct letter for iter_tion', 'Adopted'),
    (27, 2, 'Select the correct letter for auton_mous', 'Adopted'),
    (28, 2, 'Select the correct letter for ove_see', 'Adopted'),
    (29, 2, 'Select the correct letter for aband_n', 'Adopted'),
    (30, 2, 'Select the correct letter for abil_ty', 'Adopted'),
    (31, 2, 'Select the correct letter for fre_dom', 'Adopted'),
    (32, 2, 'Select the correct letter for constr_ction', 'Adopted'),
    (33, 2, 'Select the correct letter for pract_ce', 'Adopted'),
    (34, 2, 'Select the correct letter for ag_regate', 'Adopted'),
    (35, 2, 'Select the correct letter for obta_n', 'Adopted'),
    (36, 2, 'Select the correct letter for eff_rt', 'Adopted'),
    (37, 2, 'Select the correct letter for preci_itation', 'Adopted'),
    (38, 2, 'Select the correct letter for boo_ter', 'Adopted'),
    (39, 2, 'Select the correct letter for erup_ion', 'Adopted'),
    (40, 2, 'Select the correct letter for rel_ase', 'Adopted'),
    
    
    
    (41, 3, 'Select the same punctuation with !', 'Adopted'),
	(42, 3, 'Select the same punctuation with @', 'Adopted'),
    (43, 3, 'Select the same punctuation with #', 'Adopted'),
    (44, 3, 'Select the same punctuation with $', 'Adopted'),
    (45, 3, 'Select the same punctuation with %', 'Adopted'),
    (46, 3, 'Select the same punctuation with ^', 'Adopted'),
    (47, 3, 'Select the same punctuation with &', 'Adopted'),
    (48, 3, 'Select the same punctuation with *', 'Adopted'),
    (49, 3, 'Select the same punctuation with (', 'Adopted'),
    (50, 3, 'Select the same punctuation with )', 'Adopted'),
    (51, 3, 'Select the same punctuation with <', 'Adopted'),
    (52, 3, 'Select the same punctuation with +', 'Adopted'),
    (53, 3, 'Select the same punctuation with -', 'Adopted'),
    (54, 3, 'Select the same punctuation with :', 'Adopted'),
    (55, 3, 'Select the same punctuation with ;', 'Adopted'),
    (56, 3, 'Select the same punctuation with ?', 'Adopted'),
    (57, 3, 'Select the same punctuation with @@', 'Adopted'),
    (58, 3, 'Select the same punctuation with $#', 'Adopted'),
    (59, 3, 'Select the same punctuation with &*', 'Adopted'),
    (60, 3, 'Select the same punctuation with *&^', 'Adopted')
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
;


