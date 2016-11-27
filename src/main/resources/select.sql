
-- all root workflows, start_time, end_time
select job_id,
	array_agg(status order by insert_time) as status,
	array_agg(insert_time order by insert_time) as insert_time
from workflow_job_status
-- where job_id >= '0000028'
group by job_id
order by job_id;

-- all workflows, all actions insert_time
select job_id,
	array_agg(node_name order by insert_time) as node_names,
	array_agg(status order by insert_time) as status,
	array_agg(insert_time order by insert_time) as insert_time
from (
	select *
	from workflow_job_node_status
	where 1=1
	--and node_name not in (':start:', 'end')
	--and status like 'T:%'
	and job_id >= '0000047'
) a
group by job_id
order by job_id;

-- coordinator all actions
select *
from coordinator_action_status
-- where action_id >= '0000028';

select (string_to_array(action_id, '@'))[1] as coordinator_id,
	array_agg((string_to_array(action_id, '@'))[2] order by insert_time) as coordinator_seqs,
	array_agg(action_id order by insert_time) as action_ids,
	array_agg(status order by insert_time) as status,
	array_agg(insert_time order by insert_time) as insert_time
from coordinator_action_status
group by (string_to_array(action_id, '@'))[1]
order by (string_to_array(action_id, '@'))[1]


