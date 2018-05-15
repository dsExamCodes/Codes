class Process():

	def __init__(self, is_crashed, is_candidate):
		self.is_crashed = is_crashed
		self.is_candidate = is_candidate



process_list = []

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(False, True)
process_list.append(process)

process = Process(True, True)
process_list.append(process)


coordinator = 7
electors = [4]
temp_electors = []

for x in range(4):
	for elector_idx in electors:

		for i in range(elector_idx+1, len(process_list)):
			print('{} sends Election message to {}'.format(elector_idx, i))

		for i in range(elector_idx+1, len(process_list)):
			process = process_list[i]

			if not process.is_crashed:
				print('{} receives Election message from {}'.format(i, elector_idx))

		for i in range(elector_idx+1, len(process_list)):
			process = process_list[i]
			if not process.is_crashed:
				temp_electors.append(i)
				print('{} sends OK message to {}'.format(i, elector_idx))

		for i in range(elector_idx+1, len(process_list)):
			process = process_list[i]
			if not process.is_crashed:
				print('{} receives OK message from {}'.format(elector_idx, i))

		electors = temp_electors
		temp_electors = []
