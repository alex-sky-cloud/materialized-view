-- сначала удаляем trigger
drop trigger refresh_mat_view_after_insert_into_purchase_orders ON purchase_orders;

-- затем удаляем триггерную функцию function
drop function refresh_materialized_view();

-- создаем  procedure, которая запустит обновление материализованного представления.
CREATE OR REPLACE PROCEDURE refresh_materialized_view()
    LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW CONCURRENTLY purchase_order_summary;
END;
$$;