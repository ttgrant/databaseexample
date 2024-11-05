SELECT

    vin,

    vehicle_type,

    manufacturer,

    model_name,

    model_year,

    fuel_type,

    color,

    horsepower,

    (v.purchase_price *1.25 + (SELECT (SUM(po.unit_price * po.quantity) * 1.10 FROM `PartsOrder` po WHERE po.vin = v.vin) as sale_price)

        FROM `Vehicle` v

LEFT JOIN `VehicleColor` vc on v.vin = cv.vin

WHERE

    ((ifnull(vin = $vin, true)

        AND ifnull(vehicle_type = $vehicle_type, true)

        AND ifnull(manufacturer_name = $manufacturer_name, true)

        AND ifnull(model_year = $model_year, true)

        AND ifnull(fuel_type = $fuel_type, true)

        AND ifnull(vc.color = $color, true))

    OR (manufacturer like $keyword OR model_name like $keyword OR model_year like $keyword OR description like $keyword))

   AND (v.vin NOT IN (SELECT vin FROM `Part` WHERE status = 'Pending'))

GROUP BY vin

ORDER BY vin ASC;



