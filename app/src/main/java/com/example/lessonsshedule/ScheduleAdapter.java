package com.example.lessonsshedule;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final ScheduleSheet schedule;

    public ScheduleAdapter(Context context, ScheduleSheet schedule) {
        this.schedule = schedule;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View day = inflater.inflate(R.layout.recyclerview_day_item, parent, false);
        return new ViewHolder(day);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder holder, int position) {
        ScheduleDay day = schedule.days.get(position);
        if (day.isNahimovskyFilial) {
            holder.filial.setText(R.string.nahimovsky);
        }

        for (int i = 0; i < ScheduleSheet.ElementCount - 1; i++) {
            View row = inflater.inflate(R.layout.tablerow_pair, null, false);
            TextView pairNumber = (TextView) row.findViewById(R.id.number_tv);
            pairNumber.setText(Integer.toString(i + 1));
            for (AcademicPairViewModel pair : day.pairs) {
                if (pair.pairNumber == i) {
                    if (pair.numeratorDiscipline != null) {
                        TextView pairDiscipline = (TextView) row.findViewById(R.id.discipline_tv);
                        pairDiscipline.setText(pair.numeratorDiscipline.name);
                        TextView pairTeacher = (TextView) row.findViewById(R.id.teacher_tv);
                        pairTeacher.setText(pair.numeratorDiscipline.teacher);
                    }
                }
            }

            holder.table.addView(row);
        }

    }

    @Override
    public int getItemCount() {
        return schedule.days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TableLayout table;
        final TextView filial;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filial = itemView.findViewById(R.id.is_filial_tv);
            table = itemView.findViewById(R.id.schedule_day_tl);
        }
    }
}

